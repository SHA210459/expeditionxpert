// Funktion zum Anwenden der Filter
function applyFilters() {
    var selectedCurrency = document.getElementById('currencyFilter').value;
    var selectedClimate = document.getElementById('climateFilter').value;

    // AJAX-Aufruf an den Server, um die Reiseziele basierend auf den Filtern zu laden
    // Hier kannst du z.B. jQuery verwenden
    $.ajax({
        url: '/filterDestinations',
        type: 'GET',
        data: {
            currency: selectedCurrency,
            climate: selectedClimate
        },
        success: function(data) {
            // Aktualisiere die Tabelle mit den neuen Daten
            updateDestinationTable(data);
        },
        error: function() {
            console.log('Fehler beim Laden der Daten');
        }
    });
}

// Funktion zum Zurücksetzen der Filter
function resetFilters() {
    // Setze die Filter zurück (z.B. leere Dropdowns)
    document.getElementById('currencyFilter').value = '';
    document.getElementById('climateFilter').value = '';

    // Lade die Reiseziele ohne Filter
    applyFilters();
}

// Funktion zum Aktualisieren der Reiseziele-Tabelle
function updateDestinationTable(destinations) {
    var tableBody = document.querySelector('#destinationTable tbody');
    tableBody.innerHTML = ''; // Lösche den aktuellen Inhalt der Tabelle

    // Iteriere über die neuen Reiseziele und füge sie zur Tabelle hinzu
    destinations.forEach(function(destination) {
        var row = `<tr>
            <td>${destination.land}</td>
            <td>${destination.sprache}</td>
            <td>${destination.waehrung}</td>
            <td>${destination.klima}</td>
            <td>${destination.sicherheit}</td>
        </tr>`;
        tableBody.innerHTML += row;
    });
}
