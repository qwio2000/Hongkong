<dl>
	<#list dung1 as dung1Index>
		<dt>${dung1Index.dung } GRADE</dt>
		<dd style="height:123px">
			<ul>
				<li style="line">
					<#list dung1 as dung1Index>
					<span onClick="$.getSetban('${defaultset}','${dung1Index.casNset}')" style="cursor:pointer">${dung1Index.casNset }</span>
					</#list>
				</li>
			</ul>
		</dd>
		<#break>
	</#list>
	
	<#list dung2 as dung2Index>
		<dt>${dung2Index.dung } GRADE</dt>
		<dd style="height:123px">
			<ul>
				<li>
					<#list dung2 as dung2Index>
					<span onClick="$.getSetban('${defaultset}','${dung2Index.casNset}')" style="cursor:pointer">${dung2Index.casNset }</span>
					</#list>
				</li>
			</ul>
		</dd>
		<#break>
	</#list>
	
	<#list dung3 as dung3Index>
		<dt>${dung3Index.dung } GRADE</dt>
		<dd style="height:123px">
			<ul>
				<li>
					<#list dung3 as dung3Index>
					<span onClick="$.getSetban('${defaultset}','${dung3Index.casNset}')" style="cursor:pointer">${dung3Index.casNset }</span>
					</#list>
				</li>
			</ul>
		</dd>
		<#break>
	</#list>
</dl>
<input type="hidden" id="alertMsg1" value="${alertMsg1 }">
<input type="hidden" id="alertMsg2" value="${alertMsg2 }">
