document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('login').addEventListener('click', loginUsuario);
    document.getElementById('logout').addEventListener('click', logout);
});


async function loginUsuario(event) {
    event.preventDefault();

    let nombre = document.getElementById('inp-user').value;
    let password = document.getElementById('inp-pass').value;

    try {
        const response = await fetch("http://localhost:8080/api/auth/login", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            credentials: "include",
            body: JSON.stringify({
                nombre: nombre,
                password: password })
        });

        if (response.ok) {
            const data = await response.json();
            cargarTareas();

        } else if (response.status === 401) {
            const errorText = await response.text();
            console.log(errorText);

        } else {
            console.log("Error inesperado:", response.status);
        }

    } catch (error) {
        console.error("Error de red:", error);
    }
}

async function logout(event) {
    event.preventDefault();
    const res = await fetch("http://localhost:8080/api/auth/logout", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        credentials: "include"
    });
    if (res.ok) {
        cerrarSesion();
    } else {
        console.error("Error al cerrar sesión");
    }
    cerrarSesion();
}