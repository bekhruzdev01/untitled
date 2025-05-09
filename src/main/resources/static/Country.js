$(document).ready(function () {
    $("#countryTable").DataTable({
        ajax:
        {
            url: "/country/list",
            dataSrc: ""
        },
        columns: [
        {data: "id", title: "Id"},
        {data: "name", title: "Name"},
        {data: "code", title: "Code"},
        ]
    })
})