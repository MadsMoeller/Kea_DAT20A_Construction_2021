const galleriesGalleryTableBody = document.getElementById("galleries-tbody");

fetch(baseURL + "/galleries")
    .then(response => response.json())
    .then(result => {
        result.map(createGalleryTableRow)
    });

function createGalleryTableRow(gallery){
    const galleryTableRow = document.createElement("tr")
    galleryTableRow.id = gallery.id;
    galleriesGalleryTableBody.appendChild(galleryTableRow);
    constructGalleryTableRow(galleryTableRow, gallery);

}

function constructGalleryTableRow(galleryTableRow, gallery) {
    galleryTableRow.innerHTML =
        `
        <tr>
            <td>
                <a href="./gallery.html?galleryId=${gallery.id}">
                    <p class="row-gallery-name">${escapeHTML(gallery.name)}</p>
                </a>
            </td>
            <td><p class="row-gallery-location">${escapeHTML(gallery.location)}</p></td>
            <td><p class="row-gallery-square-meters">${escapeHTML(gallery.squareMeters.toString())}</p></td>
            <td><button id="update-button-${gallery.id}">🔧</button></td>
            <td><button onclick="deleteGallery(${gallery.id})">❌</button></td>
        </tr>
        `

    document.getElementById(`update-button-${gallery.id}`)
        .addEventListener("click", () => updateGallery(gallery));
}

function deleteGallery(galleryId) {
    fetch(baseURL + "/galleries/" + galleryId, {
        method: "DELETE"
    }).then(response => {
        if (response.status === 200) {
            document.getElementById(galleryId).remove();
        } else {
            console.log(response.status);
        }
    });
}

document.getElementById("create-gallery").addEventListener("click", createGallery);