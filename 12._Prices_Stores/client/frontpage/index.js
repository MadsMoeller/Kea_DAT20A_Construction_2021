console.log("index-test")

const storesTableBody = document.getElementById("stores-tbody");

fetch("http://localhost:8080/stores")
    .then(response => response.json())
    .then(stores => {
        console.log(stores)
        stores.map(createStoreTableRow);
    });

function createStoreTableRow(store){
    console.log(store)
    const storeTableRow = document.createElement("tr");
    storeTableRow.id = store.id;

    storesTableBody.appendChild(storeTableRow);

    constructStoreTableRow(storeTableRow, store);
}

function constructStoreTableRow(storeTableRow, store){
    storeTableRow.innerHTML =
        `
            <td>
                <a href="../stores/store.html?storeId=${store.id}">
                    <p class="store-select">Store ${store.storeName}</p>
                </a>
            </td>
            <td>
                <p>${store.owner}</p>
            </td>
            <td>
                <p>${store.type}</p>
            </td>
            <td>
                <p>${store.madeIn}</p>
            </td>
            <td>
                <button onclick="deleteAllPricesByStoreId(${store.id})">❌</button>
            </td>
        `
}

function deleteAllPricesByStoreId(storeId){
    fetch("http://localhost:8080/prices/" + storeId, {
        method: "DELETE",
        headers: { "Content-type": "application/json; charset=UTF-8" }
    }).catch(error => console.log(error));
}