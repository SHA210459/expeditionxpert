// Funktion zum Abrufen und Anzeigen der Reiseziele basierend auf den Filteroptionen
function applyFilters() {
    const currencyFilter = document.getElementById('currencyFilter').value;
    const climateFilter = document.getElementById('climateFilter').value;

    fetch(`/api/countries?currency=${currencyFilter}&climate=${climateFilter}`)
        .then(response => response.json())
        .then(data => {
            const destinationList = document.getElementById('destinationList');
            destinationList.innerHTML = '';

            data.forEach(country => {
                const destinationElement = document.createElement('div');
                destinationElement.classList.add('destination');

                const countryName = document.createElement('h3');
                countryName.textContent = country.name;

                const currency = document.createElement('p');
                currency.textContent = `Währung: ${country.currency}`;

                const climate = document.createElement('p');
                climate.textContent = `Klima: ${country.climate}`;

                // Weitere Informationen je nach Bedarf hinzufügen (z.B. Sprache, Sicherheit)

                destinationElement.appendChild(countryName);
                destinationElement.appendChild(currency);
                destinationElement.appendChild(climate);

                destinationList.appendChild(destinationElement);
            });
        })
        .catch(error => {
            console.error('Error fetching data:', error);
        });
}

// Funktion zum Zurücksetzen der Filteroptionen und Anzeige aller Reiseziele
function resetFilters() {
    document.getElementById('currencyFilter').value = '';
    document.getElementById('climateFilter').value = '';
    applyFilters(); // Zeige alle Reiseziele ohne Filter an
}

// Initialisierung: Anzeigen aller Reiseziele beim Laden der Seite
applyFilters();
