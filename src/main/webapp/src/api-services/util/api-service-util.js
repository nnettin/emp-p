import {inject} from 'aurelia-framework';
import {HttpClient, json} from 'aurelia-fetch-client';
import {AureliaConfiguration} from 'aurelia-configuration';


@inject(AureliaConfiguration, HttpClient)
export class ApiServiceUtil{

	constructor(config, httpClient){
		this.config = config;
		httpClient.configure(config => {
	      config.useStandardConfiguration().withBaseUrl(this.url);
	    });
		this.httpClient = httpClient;
	}

	async fetch(url, data, method){

		let toUrl = url;

		let jsonData = null;

		try{

			let responseData = null;
			if(method == 'get')
			{
				debugger;
				responseData = await this.httpClient.fetch(data==null?toUrl:toUrl+"/"+data, 
				{
	                 method: method,        
	                 headers: {
	                   'content-type': 'application/json'
	                 }
	                 
	              }
				);
			}else
			{
				debugger;
				responseData = await this.httpClient.fetch(toUrl, 
				{
	                 method: method,        
	                 headers: {
	                   'content-type': 'application/json'
	                 },
	                 body: data == null || data == undefined?'':JSON.stringify(data)
	                 
	              }
				);
			}
			
			if(responseData.ok){
				jsonData = responseData.json();
			}else{
				debugger;
				console.log("call failed:"+responseData.status+", "+responseData.statusText);
			}
		}catch(error){
			debugger;
			console.log("Fetch Error:"+error);
		}
		return jsonData;
	}

}