const phoneElem = document.getElementById('phone');
const ageElem = document.getElementById('age');
const copiesElem = document.getElementById('copies');
const priceElem = document.getElementById('price');

if (phoneElem) {
    phoneElem.addEventListener('input', (event) => {
        const element = event.target;

        element.value = element.value.replace(/\D/g, '');
    });
}

if (ageElem) {
    ageElem.addEventListener('input', (event) => {
        const element = event.target;

        element.value = element.value.replace(/\D/g, '');
    });
}

if (copiesElem) {
    copiesElem.addEventListener('input', (event) => {
        const element = event.target;

        element.value = element.value.replace(/\D/g, '');
    });
}

if (priceElem) {
    priceElem.addEventListener('input', (event) => {
        const element = event.target;

        element.value = element.value.replace(/\D/g, '');
    });
}
