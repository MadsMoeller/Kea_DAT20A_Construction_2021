const galleryFormParentDiv = document.getElementById("create-gallery-form");
const galleryFormExpandButton = document.getElementById("expand-gallery-form");

const createGalleryForm = `<div>
    <label>Name</label>
    <input id="create-gallery-name" placeholder="name">
    <label>Location</label>
    <input id="create-gallery-location" placeholder="location">    
    <label>Owner</label>
    <input id="create-gallery-owner" placeholder="owner">    
    <label>Square Meters</label>
    <input id="create-gallery-square-meters" type = "number" placeholder="square meters">
    <button onclick="removeGalleryForm()">Cancel</button>
    <button onclick="createGallery()">Create A New Gallery</button>
</div>`;


function showGalleryForm() {
    galleryFormExpandButton.style.display = "none";
    galleryFormParentDiv.innerHTML = createGalleryForm;
}

function removeGalleryForm() {
    galleryFormExpandButton.style.display = "block";
    galleryFormParentDiv.innerHTML = "";
}

function createGallery() {

    const galleryToCreate = {
        name: document.getElementById("create-gallery-name").value,
        location: document.getElementById("create-gallery-location").value,
        owner: document.getElementById("create-gallery-owner").value,
        squareMeters: document.getElementById("create-gallery-square-meters").value
    }

    fetch(baseURL + "/galleries", {
        method: "POST",
        headers: { "Content-type": "application/json; charset=UTF-8" },
        body: JSON.stringify(galleryToCreate)
    }).then(response => response.json())
        .then(gallery => {
            createGalleryTableRow(gallery);
            removeGalleryForm();
        }).catch(error => console.log(error));
}


document.getElementById("expand-gallery-form")
    .addEventListener("click", showGalleryForm);