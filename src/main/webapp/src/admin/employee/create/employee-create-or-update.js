import {inject,bindable,computedFrom} from 'aurelia-framework';
import {Router} from 'aurelia-router';
import {ApiServices} from 'api-services/api-services';

@inject(Router,ApiServices)
export class EmployeeCreate{
	constructor(router,apiServices){
		this.message = "Hello World!!";
		this.router = router;
		this.apiServices = apiServices;
		this.empData = {};
	}
	
	
	activate(params){
		if(params.id){
			this.empData.id = params.id;
			this.getEmpDetails(this.empData.id);
		}
	}
	
	async createEmp(){
		let response = await this.apiServices.create(this.empData);
		if(response != null){
			this.empData = response;
			alert("create success");
			this.router.navigate('empList');
		}
	}
	
	async getEmpDetails(empId){
		let response = await this.apiServices.get(empId);
		if(response != null){
			this.empData = response;
		}
	}
	
	async updateEmp(){
		let response = await this.apiServices.update(this.empData);
		if(response != null){
			this.empData = response;
			alert("update success");
			this.router.navigate('empList');
		}
	}
	
	
}