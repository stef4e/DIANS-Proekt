// Map pinpoint

var map = L.map('map').setView([42.0057, 21.4257], 13);

L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);

let marker = new L.Marker([42.0057, 21.4257]);
marker.addTo(map);

