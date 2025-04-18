function data() {
    const books = [
        () => {
            fetch("http://localhost:8080/books")
                .then(resp => resp.json())
        }];
    const bookList = document.getElementsByTagName("tbody");
    bookList.appendChild(books.map(book =>{
        return(
            <tr>
                <td>{book.id}</td>
                <td>{book.name}</td>
                <td>{book.price}</td>
                <td>{book.writer}</td>
                <td>{book.year}</td>
            </tr>
        )
    }))
}