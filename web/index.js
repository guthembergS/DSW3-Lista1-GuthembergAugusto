var xhr = new XMLHttpRequest();
function mostrarLista(ok) {
    var tabela = document.getElementById("lista");
    var formulario = document.getElementById("formulario");
    if (ok) {
        tabela.style.display = "table";
        formulario.style.display = "none";
    } else {
        tabela.style.display = "none";
        formulario.style.display = "block";
    }
}

function mostrarListaParlamentares() {
    mostrarLista(true);
    var lista = document.querySelector("table#lista tbody");
    lista.innerHTML = "";
}




function registerEvents() {
    var alterar = document.querySelectorAll("input[type='image'][title='Alterar']");
    if (alterar !== null) {
        Array.prototype.forEach.call(alterar, function (a) {
            a.onclick = mostrarAlterar;
        });
    }
    var excluir = document.querySelectorAll("input[type='image'][title='Remover']");
    if (excluir !== null) {
        Array.prototype.forEach.call(excluir, function (a) {
            a.onclick = remover;
        });
    }
}

function tratarColecao() {
    if (xhr.readyState === 4) {
        mostrarListaParlamentares();
        var tbody = document.querySelector("table#lista tbody");
        var text = xhr.responseText;
        var lista = JSON.parse(text);
        if (lista.length > 0) {
            for (var i = 0; i < lista.length; i++) {
                var par = lista[i];
                var linha = "<td>";
                linha += "<input type='image' title='Alterar' src='imgs/alterar.png' value='" + par.codigo + "' />";
                linha += "<input type='image' title='Remover' src='imgs/remover.png' value='" + par.codigo + "' />";
                linha += "</td><td>" + par.nome + "</td>";
                var newChild = document.createElement("tr");
                tbody.appendChild(newChild);
                newChild.innerHTML = linha;
            }
        } else {
            var tr = document.createElement("tr");
            tbody.appendChild(tr);
            tr.innerHTML = "<th colspan='4'>Nao existem parlamentares cadastrados.</th>";
        }
        registerEvents();
    }
}

function listarParlamentares() {
    xhr.onreadystatechange = tratarColecao;
    xhr.open("get", "ServletPrincipal", true);
    xhr.send(null);
}

function mostrarInserir() {
    mostrarLista(false);
    var form = document.getElementById("form");
    form.reset();
}

function submeter() {
    xhr.onreadystatechange = tratarColecao;
    var form = document.getElementById("formulario");
    var formData = new FormData(form);
    if (form.submeter.value === "Alterar") {
        xhr.open("post", "ServletAlteracao", true);
    } else {
        xhr.open("post", "ServletCadastro", true);
    }
    form.submeter.value = "Inserir";
    xhr.send(formData);
    return false;
}

function addEvents() {
    listarParlamentares();
    var inserir = document.getElementById("inserir");
    inserir.onclick = mostrarInserir;
    var form = document.getElementById("form");
    form.onsubmit = submeter;
}
onload = addEvents;
