fetch(baseURL + "/artists")
    .then(response => response.json())
    .then(result => {
        result.map(createArtistCard)
    });

const artistsGalleryWrapper = document.getElementById("artists-gallery")

function createArtistCard(artist){
    const cardElement = document.createElement("div")
    cardElement.classList.add("artist-card")
    cardElement.innerHTML =
        `
        <div class="artist-image-div">
            <img src="${escapeHTML('./images/'+artist.image)}" class="artist-image">
        </div>
        <div class="artist-description-div">
            <p>${escapeHTML(artist.name)}</p>
            <p>${escapeHTML(artist.age.toString())}</p>
            <p>${escapeHTML(artist.nationality)}</p>
            <p>${escapeHTML(artist.gender)}</p>
            <p>${escapeHTML(artist.primaryStyle)}</p>
        </div>
        `
    artistsGalleryWrapper.appendChild(cardElement)
}

function createNewArtist(){
    const name = document.getElementById("create-artist-name").value
    const age = document.getElementById("create-artist-age").value
    const nationality = document.getElementById("create-artist-nationality").value
    const image = document.getElementById("create-artist-image").value
    const primaryStyle = document.getElementById("create-artist-primaryStyle").value
    const gender = document.getElementById("create-artist-gender").value

    const newArtist = {
        name: name,
        age: Number(age),
        image: image,
        gender: gender,
        nationality: nationality,
        primaryStyle: primaryStyle
    }

    //console.log(newArtist)
    fetch("http://localhost:8080/artists",{
        method: "POST",
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        },
        body: JSON.stringify(newArtist)
    })
        .then(response => {
            if (response.status === 200){
                createArtistCard(newArtist)
            }else{
                console.log("Artist not created.", response.status)
            }
        })
        .catch(error => console.log("Network related error: ", error))
}

document.getElementById("create-artist-button").addEventListener("click",createNewArtist)