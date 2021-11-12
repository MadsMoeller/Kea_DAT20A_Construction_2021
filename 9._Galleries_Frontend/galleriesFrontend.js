fetch("http://localhost:8080/artists")
    .then(response => response.json())
    .then(artists => {
        console.log(artists)
        const artistsElement = document.getElementById("artist-div")
        artists.map(artist => {
            const artistDiv = document.createElement("div")

            artistDiv.innerHTML = `
            <p>${escapeHTML(artist.name)}</p>
            <p>${escapeHTML(artist.age.toString())}</p>
            <p>${escapeHTML(artist.primaryStyle)}</p>
            <p>${escapeHTML(artist.nationality)}</p>
            <p>${escapeHTML(artist.gender)}</p>
            <br>`

            artistsElement.appendChild(artistDiv)
        })
    })
