<#import "macros/common.ftl" as com >
<#import "macros/articleInfo.ftl" as ari>
<@com.common "ALL ARTICLE FTL">
    <#list articles as article>

        <@ari.articleInfo article/>

    </#list>
</@com.common>

