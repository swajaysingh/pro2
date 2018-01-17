/**
 * JobService
 */
app.factory('JobService',function($http){
	var jobService={}
	
	JobService.addJob=function(job){
		return $http.post("http://localhost:7475/pro2middleware/savejob",job);
	}
	
	jobService.getAllJobs=function(){
		return $http.get("http://localhost:7475/pro2middleware/alljobs")
	}
	
	jobService.getJob=function(jobId){
		return $http.get("http://localhost:7475/pro2middleware/getjob/"+jobId)
	}
	
	return jobService;
})