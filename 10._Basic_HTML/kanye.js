function getKanyeQuote() {
    const quote = document.getElementById("kanye-quote");

    fetch("https://api.kanye.rest/")
        .then(response => response.json())
        .then(result => quote.innerText = result.quote);
}

getKanyeQuote()

document.getElementById("btn-kanye-wisdom").addEventListener("click", getKanyeQuote);

setInterval(getKanyeQuote, 10000);

document.getElementById("btn-laugh").addEventListener("click", () => addQuoteToList("laugh"));
document.getElementById("btn-wtf").addEventListener("click", () => addQuoteToList("wtf"));
document.getElementById("btn-jesus").addEventListener("click", () => addQuoteToList("jesus"));

function addQuoteToList(listName){
    console.log(document.getElementById("kanye-quote").innerText);
    const paragraph = document.createElement("p");
    paragraph.innerText = document.getElementById("kanye-quote").innerText;
    document.getElementById("list-" + listName).appendChild(paragraph);
}