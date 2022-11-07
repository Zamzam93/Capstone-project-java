const headers = {
    'Content-Type': 'application/json'
 }

window.onload = function(){
getMoods()
}
const baseUrl = "http://localhost:8080/api/v1/moods/"
const PastMood = document.getElementById("PastMood")


async function getMoods(userId){
 await fetch(`${baseUrl}user/1`,{
      method: "GET",
              headers: headers
 })
         .then(response => response.json())
         .then(data => {
         data.forEach(elem => {
         let listItem = document.createElement("div")
         listItem.classList.add("m-2")
         listItem.innerHTML = `<div class="card d-flex" style="width: 18rem; height: 18rem;">
                                               <div class="card-body d-flex flex-column  justify-content-between" style="height: available">
                                               <h4>${elem.category}</h4>

                                                   <p class="card-text">${elem.text}</p>
                                                   <div class="d-flex justify-content-between">




                                                   </div>
                                               </div>
                                           </div>`
         PastMood.appendChild(listItem)
         })


         .catch(err => console.error(err))

        })

}

