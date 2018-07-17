import {inject} from 'aurelia-framework';
import {ApiServiceUtil} from './util/api-service-util';

@inject(ApiServiceUtil)
export class ApiServices{
	constructor(apiServiceUtil){
		this.apiServiceUtil = apiServiceUtil;
	}
	
	async create(empObj){
		let response = await this.apiServiceUtil.fetch("api/emp/create",empObj,"POST");
		
		return response;
	}
	
	async delete(empId){
		let response = await this.apiServiceUtil.fetch("api/emp/delete",empId,"get");
		
		return response;
	}
	
	async update(empObj){
		let response = await this.apiServiceUtil.fetch("api/emp/update",empObj,"POST");
		
		return response;
	}
	
	async list(){
		let response = await this.apiServiceUtil.fetch("api/emp/list",null,"get");
		
		return response;
	}
	
	async get(empId){
		let response = await this.apiServiceUtil.fetch("api/emp/get",empId,"get");
		
		return response;
	}
}