const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const galleryId = urlParams.get("galleryId");

fetch(baseURL+"/galleries/" + galleryId)
    .then(response => response.json())
    .then(gallery => {
        document.getElementById("gallery-name").innerText = gallery.name;
        document.getElementById("gallery-location").innerText = gallery.location;
        document.getElementById("gallery-owner").innerText = gallery.owner;
        document.getElementById("gallery-square-meters").innerText = gallery.squareMeters;
    })