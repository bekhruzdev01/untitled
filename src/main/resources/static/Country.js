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

// $(document).ready(function () {

//     $("#addCountryForm").submit(function (e) {
//             e.preventDefault();
//             const name = $("#countryName").val();
//             const code = $("#countryCode").val();

//             $.ajax({
//                 url: "/country/save",
//                 type: "POST",
//                 contentType: "application/json",
//                 data: JSON.stringify({ name: name, code: code }),
//                 success: function () {
//                     alert("Country added successfully!");
//                     location.reload();
//                 },
//                 error: function () {
//                     alert("Error adding country.");
//                 }
//             });
//         });
// })

//  function deleteCountry(id) {
//         if (confirm("Are you sure you want to delete this country?")) {
//             $.ajax({
//                 url: "/country/delete/" + id,
//                 type: "DELETE",
//                 success: function () {
//                     alert("Country deleted successfully!");
//                     location.reload();
//                 },
//                 error: function () {
//                     alert("Error deleting country.");
//                 }
//             });
//         }
//     }

$("#addRegionForm").submit(function (e) {
    e.preventDefault();
    const name = $("#regionName").val();
    const countryId = $("#regionCountry").val();

    $.ajax({
        url: "/region/save",
        type: "POST// Add New Region Form Submission",
        contentType: "application/json",
        data: JSON.stringify({ name: name, countryId: countryId }),
        success: function () {
            alert("Region added successfully!");
            location.reload();
        },
        error: function () {
            alert("Error adding region.");
        }
    });
}
)

$("#searchInput").on("input", function () {
    const keyword = $(this).val();
    $.getJSON(`/country/search?keyword=${keyword}`, function (data) {
        const table = $("#countryTable").DataTable();
        table.clear();
        table.rows.add(data);
        table.draw();
    });
});