const queryString = window.location.search;
const URLParams = new URLSearchParams(queryString);
const storeId = parseInt(URLParams.get("storeId"));

const pricesDiv = document.getElementById("prices-display-case");

fetch("http://localhost:8080/prices/" + storeId)
    .then(response => response.json())
    .then(prices => {
        prices.map(displayPrice)
    });

function displayPrice(price){
    const priceTagParagraph = document.createElement("p");
    priceTagParagraph.innerText = price.price;
    priceTagParagraph.style.position = "absolute";
    priceTagParagraph.style.fontSize = price.size;
    priceTagParagraph.style.color = price.colour;
    priceTagParagraph.style.top = getRandomInteger(0, 100) + "%";
    priceTagParagraph.style.left = getRandomInteger(0, 100) + "%"

    pricesDiv.append(priceTagParagraph);
}

function createNewPrice(){
    const price = {
        price: getRandomFloat(1.5, 35),
        size: getRandomInteger(4, 38) + "px",
        colour: generateRandomColour()
    };

    sendPriceToBackend(price);

    displayPrice(price);
}

function getRandomFloat(min, max){
    return ((Math.random() * (max - min)) + min).toFixed(2);
}

function getRandomInteger(min, max){
    return Math.floor((Math.random() * (max - min)) + min);
}

function generateRandomColour(){
    let randomColour = "#" + Math.floor(Math.random() * 16777215).toString(16);
    return randomColour;
}

function sendPriceToBackend(price){
    fetch("http://localhost:8080/prices/" + storeId, {
        method: "POST",
        headers: { "Content-type": "application/json; charset=UTF-8" },
        body: JSON.stringify(price)
    })
        .then(response => response.json())
        .catch(error => console.log(error))
}

document.addEventListener("click", () => {
    createNewPrice();
    createNewPrice();
    createNewPrice();
    createNewPrice();
    createNewPrice();
    createNewPrice();
    createNewPrice();
})