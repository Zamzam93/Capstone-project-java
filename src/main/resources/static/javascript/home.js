var emoji = document.getElementById('emoji');
var mood = document.getElementById('mood');
var sliderValue = document.getElementById('range');
//var btnCheck = document.querySelector('.check-in');

const headers = {
    'Content-Type': 'application/json'
}


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

    document.getElementById('message').innerHTML = "This Feeling Will Pass.";
  }
  else if(mood.innerHTML == 'Sad'){
  document.getElementById('message').innerHTML = "It's okay to not be okay.Everyone has good and bad days.";
  }
  else if(mood.innerHTML == 'Anxious'){
  document.getElementById('message').innerHTML = "Go easy on yourself.Whatever you do today, let it be enough.";
  }
  else if( mood.innerHTML == 'Happy'){
  document.getElementById('message').innerHTML = "Wonderful"
  }
  else if( mood.innerHTML == 'Joyful'){
  document.getElementById('message').innerHTML = "You are doing amazing"


  }
}


btnCheck.addEventListener('click', checkInMessage);

const moodInput = document.getElementById("mood-input")
const saveButton = document.getElementById('update-mood-mood-button')
async function addMood(obj){
    let noteObj = {
        category: mood.innerHTML,
        text: moodInput.value
    }
    const response = await fetch('http://localhost:8080/api/v1/moods/user/1',{
        method: "POST",
        body: JSON.stringify(noteObj),
        headers: headers
    })
        .catch(err => console.error(err.message))
    if (response.status == 200) {
        return getMoods(userId);
    }




}


async function getMoods(userId) {
    await fetch(`${baseUrl}user/${userId}`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => createMoodCards(data))
        .catch(err => console.error(err))
}

async function getMoodById(moodId){
   await fetch(baseUrl + moodId,{
           method: "GET",
           headers: headers
       })
          .then(res => res.json())
          .then(data => populateModal(data))
          .catch(err => console.error(err.message))

}

async function handleMoodEdit(moodId){
let noteObj = {
        category: mood.innerHTML,
        text: moodInput.value
    }

    await fetch(baseUrl, {
            method: "PUT",
            body: JSON.stringify(bodyObj),
            headers: headers
        })
            .catch(err => console.error(err))

        return getMoods(userId);
    }
}

async function handleDelete(moodId){
    await fetch(baseUrl + moodId, {
        method: "DELETE",
        headers: headers
    })
        .catch(err => console.error(err))

    return getMoods(userId);
}

const createMoodCards = (array) => {
    moodContainer.innerHTML = ''
    array.forEach(obj => {
        let moodCard = document.createElement("div")
        moodCard.classList.add("m-2")
        moodCard.innerHTML = `
            <div class="card d-flex" style="width: 18rem; height: 18rem;">
                <div class="card-body d-flex flex-column  justify-content-between" style="height: available">
                    <p class="card-text">${obj.body}</p>
                    <div class="d-flex justify-content-between">
                        <button class="btn btn-danger" onclick="handleDelete(${obj.id})">Delete</button>
                        <button onclick="getMoodById(${obj.id})" type="button" class="btn btn-primary"
                        data-bs-toggle="modal" data-bs-target="#note-edit-modal">
                        Edit
                        </button>
                    </div>
                </div>
            </div>
        `
        moodContainer.append(moodCard);
    })
}





btnCheck.addEventListener('click', checkInMessage);
saveButton.addEventListener('click', addMood);







