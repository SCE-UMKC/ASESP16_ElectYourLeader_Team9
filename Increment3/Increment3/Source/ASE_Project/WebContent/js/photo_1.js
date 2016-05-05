(function () {
	var video = document.getElementById('video'),
		canvas = document.getElementById('canvas'),
		context = canvas.getContext('2d'),
		vendorUrl = window.URL || window.webkitURL;
		
	navigator.getMedia = navigator.getUserMedia ||
						 navigator.webkitGetUserMedia ||
						 navigator.mozGetUserMedia ||
						 navigator.msGetUserMedia;
	
	navigator.getMedia({
		video:true,
		audio:false
	}, function(stream) {
		video.src = vendorUrl.createObjectURL(stream);
		video.play();
	}, function(){
		//error code
	});
	
	document.getElementById('capture').addEventListener('click',function() {
		context.drawImage(video,0,0,150,100);
		image.setAttribute('src',canvas.toDataURL('image/png'));
		
	})
	
})();