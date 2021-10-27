const list = [1, 2, 3, 4, 5];

const squaredList = list.map(number => number * number);
console.log(squaredList);

const isOdd = list.filter(number => number % 2 != 0);
console.log(isOdd);

const kajkager =[{
    type: "Andrea",
    colour: "blue",
    deliciousness: 8
}];

kajkager.push({
    type: "Kaj",
    colour: "green",
    deliciousness: 10
});

console.log(kajkager);

const tbodyElement = document.getElementById("cake-tbody")

const hardCaketData = {
    type: "Kaj",
    colour: "Purple",
    deliciousness: 11
}

/*
tbodyElement.innerHTML = `
    <tr>
        <td>${escapeHTML(kajkager[0].type)}</td>
        <td>${escapeHTML(kajkager[0].colour)}</td>
        <td>${escapeHTML(kajkager[0].deliciousness.toString())}/10</td>
    </tr>
`;
 */

kajkager.map(cake => {
    const tableRowElement = document.createElement("tr");
    tableRowElement.innerHTML = `
    <tr>
        <td>${escapeHTML(cake.type)}</td>
        <td>${escapeHTML(cake.colour)}</td>
        <td>${escapeHTML(cake.deliciousness.toString())}/10</td>
    </tr>
`
    tbodyElement.appendChild(tableRowElement);
})

