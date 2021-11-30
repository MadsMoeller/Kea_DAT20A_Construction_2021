const charachterGalleryDiv = document.getElementById("character-gallery")
let characters;
let filteredCharacters;

fetch("https://rickandmortyapi.com/api/character")
    .then(response => response.json())
    .then(result => {
        characters = result.results;
        filteredCharacters = characters;
        characters.map(character => createCharacterCard(character))
    });

function createCharacterCard(character){
    console.log(character)
    const cardElement = document.createElement("div")
    cardElement.innerHTML = `
        <p>${escapeHTML(character.name)}</p>
        <img src="${escapeHTML(character.image)}">
`
    charachterGalleryDiv.appendChild(cardElement)
    //console.log(characters.length);
}



function searchCharachters(){
    const status = document.getElementById("status-dropdown").value;
    //console.log(status)
    charachterGalleryDiv.innerHTML = "";
    if(status === "All"){
        filteredCharacters = characters;
        characters.map(createCharacterCard)
    }else{
        filteredCharacters = characters.filter(character => character.status === status)
        filteredCharacters.map(createCharacterCard)
    }
}

function handleSearchName(event){
    console.log(event.target.value)
    charachterGalleryDiv.innerHTML = "";
    filteredCharacters.filter(character => character.name.toLowerCase().includes(event.target.value)).map(createCharacterCard);
}

document.getElementById("search-btn").addEventListener("click", searchCharachters)
document.getElementById("name-search").addEventListener("input", handleSearchName)