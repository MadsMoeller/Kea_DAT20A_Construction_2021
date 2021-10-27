fetch("https://pokeapi.co/api/v2/pokemon/")
    .then(response => response.json())
    .then(result => {
        result.results.map(pokemon => addPokemonToPokelist(escapeHTML(pokemon.name)))
    });

function addPokemonToPokelist(pokeName){
    const pokeDivElement = document.getElementById("pokemon-tbody")
    const pokeNameParagraph = document.createElement("p")
    pokeNameParagraph.innerText = pokeName
    pokeDivElement.appendChild(pokeNameParagraph)

    //console.log(pokemon)
}



