<#-- このテンプレートに対応するデータモデルのクラスは org.seasar.doma.extension.gen.EntityDesc です -->

<#-- (1)カスタマイズfunction定義 -->
<#function convertDataType dataType>
  <#local result = dataType?replace("Byte", "Integer")>
  <#local result = result?replace("int", "Integer")>
  <#local result = result?replace("Short", "Integer")>
  <#return result>
</#function>
<#function addElement columnName>
  <#if columnName == "create_time">
    <#return ", insertable=false">
  <#elseif columnName == "updated_datetime">
    <#return ", insertable=false, updatable=false">
  </#if>
  <#return "">
</#function>
<#-- (1)カスタマイズfunction定義 -->

<#import "/lib.ftl" as lib>
<#if lib.copyright??>
  ${lib.copyright}
</#if>
<#if packageName??>
  package ${packageName};
</#if>

<#list importNames as importName>
  import ${importName};
</#list>

/**
<#if showDbComment && comment??>
  * ${comment}
</#if>
<#if lib.author??>
  * @author ${lib.author}
</#if>
*/
@Entity<#if useListener || namingType != "NONE">(</#if><#if useListener>listener = ${listenerClassSimpleName}.class</#if><#if namingType != "NONE"><#if useListener>, </#if>naming = ${namingType.referenceName}</#if><#if useListener || namingType != "NONE">)</#if>
<#if showCatalogName && catalogName?? || showSchemaName && schemaName?? || showTableName && tableName??>
  @Table(<#if showCatalogName && catalogName??>catalog = "${catalogName}"</#if><#if showSchemaName && schemaName??><#if showCatalogName && catalogName??>, </#if>schema = "${schemaName}"</#if><#if showTableName><#if showCatalogName && catalogName?? || showSchemaName && schemaName??>, </#if>name = "${tableName}"</#if>)
</#if>
public class <#if entityPrefix??>${entityPrefix}</#if>${simpleName}<#if entitySuffix??>${entitySuffix}</#if><#if superclassSimpleName??> extends ${superclassSimpleName}</#if> {
<#list ownEntityPropertyDescs as property>

  <#if showDbComment && property.comment??>
    /** ${property.comment} */
  <#else>
    /** */
  </#if>
  <#if property.id>
    @Id
    <#if property.generationType??>
      @GeneratedValue(strategy = ${property.generationType.referenceName})
      <#if property.generationType == "SEQUENCE">
        @SequenceGenerator(sequence = "${tableName}_${property.columnName}"<#if property.initialValue??>, initialValue = ${property.initialValue}</#if><#if property.allocationSize??>, allocationSize = ${property.allocationSize}</#if>)
      <#elseif property.generationType == "TABLE">
        @TableGenerator(pkColumnValue = "${tableName}_${property.columnName}"<#if property.initialValue??>, initialValue = ${property.initialValue}</#if><#if property.allocationSize??>, allocationSize = ${property.allocationSize}</#if>)
      </#if>
    </#if>
  </#if>
  <#if property.version>
    @Version
  </#if>
  <#if property.showColumnName && property.columnName??>
  <#-- (2)アノテーションに要素追加 -->
    @Column(name = "${property.columnName}"${addElement(property.columnName)})
  </#if>
<#-- (3)変数の型変換 -->
  <#if !useAccessor>public </#if>${convertDataType(property.propertyClassSimpleName)} ${property.name};
</#list>
<#if originalStatesPropertyName??>

  /** */
  @OriginalStates
  <#if entityPrefix??>${entityPrefix}</#if>${simpleName}<#if entitySuffix??>${entitySuffix}</#if> ${originalStatesPropertyName};
</#if>
<#if useAccessor>
  <#list ownEntityPropertyDescs as property>

    /**
    * Returns the ${property.name}.
    *
    * @return the ${property.name}
    */
  <#-- (4)戻り値の型変換 -->
    public ${convertDataType(property.propertyClassSimpleName)} get${property.name?cap_first}() {
    return ${property.name};
    }

    /**
    * Sets the ${property.name}.
    *
    * @param ${property.name} the ${property.name}
    */
  <#-- (5)引数の型変換 -->
    public void set${property.name?cap_first}(${convertDataType(property.propertyClassSimpleName)} ${property.name}) {
    this.${property.name} = ${property.name};
    }
  </#list>
</#if>
}