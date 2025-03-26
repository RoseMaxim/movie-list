document.getElementById('addMovieForm').addEventListener('submit', addMovie);

function addMovie(e) {
    e.preventDefault();

    const title = document.getElementById('title').value;
    const genre = document.getElementById('genre').value;
    const director = document.getElementById('director').value;
    const releaseYear = document.getElementById('releaseYear').value;
    const review = document.getElementById('review').value;

    const movie = {
        title,
        genre,
        director,
        releaseYear,
        review
    };

    fetch('http://localhost:8080/movies', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(movie)
    })
    .then(response => response.json())
    .then(data => {
        console.log('Movie added:', data);
        fetchMovies(); // Refresh the movie list
    })
    .catch(error => console.error('Error:', error));
}

function fetchMovies() {
    fetch('http://localhost:8080/movies')
        .then(response => response.json())
        .then(data => {
            const movieList = document.getElementById('movieList');
            movieList.innerHTML = '';
            data.forEach(movie => {
                const li = document.createElement('li');
                li.textContent = `${movie.title} (${movie.releaseYear}) - Genre: ${movie.genre}, Director: ${movie.director}`;
                movieList.appendChild(li);
            });
        })
        .catch(error => console.error('Error:', error));
}

fetchMovies();
