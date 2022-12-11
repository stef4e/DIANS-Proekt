// Map pinpoint

var map = L.map('map').setView([42.0057, 21.4257], 13);

L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);

let marker = new L.Marker([42.0057, 21.4257]);
marker.addTo(map);

/*
 L.marker([41.9956368, 21.4268858]).addTo(map)
     .bindPopup('Клуб Авенија <br/>' +
         'Nightclub <br/>')
     .openPopup();

*/
// L.marker([42.0001669, 21.4369808]).addTo(map)
//     .bindPopup('Клуб капан ан <br/>' +
//         'Bar <br/>')
//     .openPopup();
//
// L.marker([41.9993401, 21.4358564]).addTo(map)
//     .bindPopup('Hürrem <br/>' +
//         'Bar <br/>')
//     .openPopup();
//
// L.marker([41.9975241, 21.4295352]).addTo(map)
//     .bindPopup('La mer <br/>' +
//         'Bar <br/>')
//     .openPopup();


// "2695392370","сектор909","nightclub","point (21.4322415 41.9951965)"
// "2823030395","xo club","nightclub","point (21.4323787 41.9958947)"
// "2823030396","етно-бар","bar","point (21.4340509 41.9955386)"
// "2823030397","клуб „привилиџ“","nightclub","point (21.435389 41.9946393)"
// "2850243726","иридиум 77","nightclub","point (21.4353642 41.9951381)"
// "3101726039","rakija bar","bar","point (21.4358296 41.9998288)"
// "3648714484","брик бар","bar","point (21.4285673 42.0056059)"
// "3812500134","balet","nightclub","point (21.4240507 41.9979568)"
// "4358669396","samocod","bar","point (21.441738 41.99462)"
// "4386697491","tavce gravce","bar","point (21.4363148 41.9996587)"
// "4386763889","beer cafe","bar","point (21.4367578 41.9999897)"
// "4710531782","bar reka","bar","point (21.4264446 42.0068068)"
// "4794044627","speakeasy","bar","point (21.4235498 42.00231)"
// "4881325493","minus eden","bar","point (21.4061819 42.0062605)"
// "4908711070","летен клуб „батлер“","nightclub","point (21.4207487 42.007769)"
// "4908711071","летен клуб „копакабана“","nightclub","point (21.4211163 42.0074138)"
// "4908711072","летен клуб „xl“","nightclub","point (21.4209542 42.0081867)"
// "5025833449","епицетар","nightclub","point (21.4206127 42.0068653)"
// "5025833450","летен клуб „централ парк“","nightclub","point (21.4228536 42.0079675)"
// "5110720232","syri","bar","point (21.4378235 42.001291)"
// "5129209624","papillon","bar","point (21.4211669 42.0004422)"
// "5284221297","kaldrma","bar","point (21.4216722 42.0021654)"
// "5284221299","van gogh","bar","point (21.421779 42.0022762)"
// "5324087246","tesla bar","bar","point (21.410801 42.005228)"
// "5339772021","centar bar","bar","point (21.4290413 41.9947621)"
// "5484708477","thirio","bar","point (21.4268797 42.0007066)"
// "5659318796","radio bar","bar","point (21.423451 42.0002331)"
// "6466749619","mr. jack","bar","point (21.4268984 41.9964359)"
// "6812666808","distrikt","bar",
//     "6815931385","nano","bar","point (21.4209912 42.0003784)"
// "6970147987","кафе и сине котур","bar","point (21.4296298 41.994404)"
// "7026834385","mezo club","nightclub","point (21.4245713 41.9957303)"
// "7145674630","marvel coffee bar","bar","point (21.4108493 42.0052205)"