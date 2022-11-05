var emoji = document.getElementById('emoji');
var mood = document.getElementById('mood');
var sliderValue = document.getElementById('range');
//var btnCheck = document.querySelector('.check-in');



sliderValue.oninput = function() {
    var value = this.value;
    if(value <=20){
        emoji.innerHTML = '&#128543;';
        mood.innerHTML = 'Worried';
    }
    else if(value <=40){
        emoji.innerHTML = '&#128545;';
        mood.innerHTML = 'Sad';
    }
    else if (value <=60){
        emoji.innerHTML = '&#128532;';
        mood.innerHTML = 'Anxious';
    }
    else if(value <=80){
        emoji.innerHTML = '&#128522;';
        mood.innerHTML = 'Happy';
    }
    else if(value <=100){
        emoji.innerHTML = '&#128514;';
        mood.innerHTML = 'Joyful';
    }


}
//function checkInMessage(){
//
//document.getElementById('message').innerHtml = 'you will be okay';
//
//}
//btnCheck.addEventListener('click',checkInMessage);

const btnCheck = document.querySelector('.check-in');




function checkInMessage() {
if(mood.innerHTML == 'Worried'){

    document.getElementById('message').innerHTML = "You will be okay";
  }
  else if(mood.innerHTML == 'Sad'){
  document.getElementById('message').innerHTML = "You will be happy soon";
  }
  else if(mood.innerHTML == 'Anxious'){
  document.getElementById('message').innerHTML = "You will be happy glad";
  }
  else if( mood.innerHTML == 'Happy'){
  document.getElementById('message').innerHTML = "You will be happy excited"
  }
  else if( mood.innerHTML == 'Joyful'){
  document.getElementById('message').innerHTML = "You are doing amazing"


  }
}


btnCheck.addEventListener('click', checkInMessage);







