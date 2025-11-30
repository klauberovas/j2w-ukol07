[#ftl]

[#macro page title="Blog"]
    <!doctype html>
    <html lang="cs">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>${title}</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
        <body>
            [@navbar /]
            <div class="container mt-5">
                [#nested]
            </div>
        </body>
    </html>
[/#macro]

[#macro navbar]
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">Blog</a>
        </div>
    </nav>
[/#macro]

[#macro postCard post]
    <div class="col-md-12 mb-4">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">${post.title}</h5>
                <p class="card-text text-muted">
                    <small>
                        Autor: <strong>${post.author}</strong> |
                        Publikováno: <strong>${post.published?string("d.M.yyyy")}</strong>
                    </small>
                </p>
                <div class="card-text">
                    ${post.perex?no_esc}
                </div>
                <a href="/${post.slug}" class="btn btn-primary btn-sm mt-3">
                    Přečíst celý příspěvek →
                </a>
            </div>
        </div>
    </div>
[/#macro]

[#macro postDetail post]
    <article>
        <h1 class="mb-4">${post.title}</h1>

        <div class="mb-4 pb-3 border-bottom">
            <small class="text-muted">
                Autor: <strong>${post.author}</strong> |
                Publikováno: <strong>${post.published?string("d.M.yyyy")}</strong>
            </small>
        </div>

        <div class="lead mb-4">
            ${post.perex?no_esc}
        </div>

        <div class="post-content">
            ${post.body?no_esc}
        </div>

        <hr class="my-5">

        <div>
            <a href="/" class="btn btn-secondary">
                ← Zpět na seznam příspěvků
            </a>
        </div>
    </article>
[/#macro]