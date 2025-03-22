document.getElementById('phone').addEventListener('input', (event) => {
    const element = event.target;

    element.value = element.value.replace(/\D/g, '');
});
