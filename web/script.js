async function data() {
    try {
        const response = await fetch("http://localhost:8080/books");
        if (!response.ok) {
            throw new Error(`HTTP xatolik: ${response.status}`);
        }
        const books = await response.json();
        const bookList = document.getElementById("book-list");
        bookList.innerHTML = ""; // Avvalgi ma'lumotlarni tozalash

        books.forEach((book, index) => {
            const row = document.createElement("tr");

            row.innerHTML = `
                <td>${index + 1}</td>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.writer}</td>
                <td>${book.year}</td>
                <td><button class="btn btn-warning btn-sm">Tahrirlash</button></td>
                <td><button class="btn btn-danger btn-sm">O'chirish</button></td>
            `;

            bookList.appendChild(row);
        });
    } catch (error) {
        console.error("Ma'lumotlarni olishda xatolik:", error);
    }
}

// Sahifa yuklanganda data() funksiyasini chaqirish
window.onload = data;
