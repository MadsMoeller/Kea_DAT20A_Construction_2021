console.log("virker det her?")

const paintingsGalleryDiv = document.getElementById("paintings-gallery");

fetch(baseURL + "/paintings")
    .then(response => response.json())
    .then(paintings => paintings.map(createPaintingCard));

//opretter selve card'et, kalder constructPaintingCard()
function createPaintingCard(painting){
    const paintingCardDiv = document.createElement("div");
    paintingsGalleryDiv.appendChild(paintingCardDiv);
    constructPaintingCard(paintingCardDiv, painting)

    console.log(painting)
}

//tilføjer information til card'et
function constructPaintingCard(paintingDiv, painting){
    paintingDiv.innerHTML =
        `
        <h3>${painting.title}</h3>
        `

}

function createPainting(){
    console.log("create painting")
}

document.getElementById("create-painting-button").addEventListener("click", createPainting);