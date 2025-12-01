[#ftl]

[@c.page title="Blog - Seznam příspěvků"]
    <h1 class="mb-4">Nejnovější příspěvky</h1>

    [#if posts?has_content]
        <div class="row">
            [#list posts.content as post]
                [@c.postCard post /]
            [/#list]
            [@c.pager posts /]
        </div>
    [#else]
        <div class="alert alert-info">Žádné příspěvky k zobrazení.</div>
    [/#if]
[/@c.page]
