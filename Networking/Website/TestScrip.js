// ES6 Syntax
// Idea by @dayanabliss
// Current implementation by Davis Cook

function prepareThumbs(){
    let bucket = document.getElementById('thumb-bucket'),
        smallThumbNails = bucket.getElementsByTagName('img'),
        largeImg = document.getElementById('long-text');

    //Set large image based on first thumbnail
    largeImg.src = smallThumbNails[0].src;
    setLarge(largeImg.src.split("?")[1]);

    function setLarge(src){
      largeImg.src = `https://picsum.photos/600/450/?${src}`;
    }

    //iterate through all thumbnails to determine who was hovered on and set source
    for(var i = 0; i < smallThumbNails.length; i++){
      this.thumbImg = smallThumbNails[i];
      this.thumbImg.addEventListener("mouseover", function(){
        let imgSrc = this.src.split("?")[1];
        setLarge(imgSrc);
      });
    }
}

prepareThumbs();

var Me =
var Where =
var Classes =
var Portrait = 
