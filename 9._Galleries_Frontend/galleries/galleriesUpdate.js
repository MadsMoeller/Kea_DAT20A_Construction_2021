function updateGallery(gallery){
    console.log("Update gallery with id:", gallery.id)
    const tableRowToUpdate = document.getElementById(gallery.id)

    tableRowToUpdate.innerHTML =
        `
        <tr>
            <td><input id="update-gallery-name-${gallery.id}" value=" ${escapeHTML(gallery.name)}"></td>
            <td><input id="update-gallery-location-${gallery.id}" value="${escapeHTML(gallery.location)}"></td>
            <td><input id="update-gallery-square-meters-${gallery.id}" type="number" value="${escapeHTML(gallery.squareMeters.toString())}"</td>
            <td>
                <button onclick="updateGalleryInBackend(${gallery.id})">✔️</button>
                <button id="cancel-update-${gallery.id}">🛑</button>
            </td>
            <td><button onclick="deleteGallery(${gallery.id})">❌</button></td>
        </tr>
        `
    document.getElementById(`cancel-update-${gallery.id}`)
        .addEventListener("click", () => undoUpdateTableRow(gallery))
}

function undoUpdateTableRow(gallery){
    console.log("cancel")
    const galleryTableRow = document.getElementById(gallery.id)
    createGalleryTableRow(galleryTableRow, gallery)

    document.getElementById(`update-button-${gallery.id}`)
        .addEventListener("click", () => updateGallery(gallery));

}

function updateGalleryInBackend(galleryId){

    const tableRowToUpdate = document.getElementById(galleryId);
    const galleryToUpdate = {
        id: galleryId,
        name: document.getElementById(`update-gallery-name-${galleryId}`).value,
        location: document.getElementById(`update-gallery-location-${galleryId}`).value,
        squareMeters: document.getElementById(`update-gallery-square-meters-${galleryId}`).value
    }

    fetch(baseURL + "/galleries/" + galleryId, {
        method: "PATCH",
        headers: { "Content-type": "application/json; charset=UTF-8" },
        body: JSON.stringify(galleryToUpdate)
    }).then(response => {
        if (response.status === 200){
            console.log("You go, cowboy!")
        }
    });


}