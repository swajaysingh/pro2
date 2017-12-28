/**
 * Job Controller
 */
app.controller('JobController', function($scope, JobService, $location) {
$scope.showDetails=false
$scope.searchTxt=""
	$scope.addJob = function() {
		JobService.addJob($scope.Job).then(function(response) {
			alert('Job Details posted successfully')
			$location.path('/home')
		}, function(response) {
			if (response.status == 401) {
				if (response.data.code == 6){
					alert('Access Denied')
					$location.path('/home')
			}
				else {
					$scope.error = response.data
					$location.path('/login')
				}
			}
			if (response.status == 500) {
				$scope.error = response.data
				$location.path('/addjob')
			}
		})
	}
	$scope.getJob=function(jobId){
		$scope.showDetails=true
		JobService.getJob(jobId).then (function(response){
		$scope.job=response.data
		},function(response){
			if(response.status==401){
				$scope.error=response.data
				$location.path('/login')
			}
		})
	}
	function getAllJobs(){
		JobService.getAllJobs().then (function(response){
			$scope.jobs=response.data
		},function(response){
			if(response.status==401){
				$scope.error=response.data
				$location.path('/login')
			}
		})
	}
	getAllJobs() //function call
})