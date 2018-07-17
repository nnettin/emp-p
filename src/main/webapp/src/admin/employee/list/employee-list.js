import {inject,bindable,computedFrom} from 'aurelia-framework';
import {Router} from 'aurelia-router';
import {ApiServices} from 'api-services/api-services';

@inject(Router,ApiServices)

export class EmployeeList{
	constructor(router,apiServices){
		this.message = "this is a emp list page";
		this.router = router;
		this.apiServices = apiServices;
		this.empList = null;
	}
	
	activate(){
		this.getList();
	}
	
	async getList(){
		let response = await this.apiServices.list();
		if(response != null){
			debugger;
			console.log("response",response);
			this.empList = response;
//			alert("get list success");
		}
	}
	
	async deleteEmployee(empId){
		debugger;
		let response = await this.apiServices.delete(empId);
		if(response != null){
			this.getList();
			alert('delete success');
		}
	}
}