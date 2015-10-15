<#function UFNDisplayJinSet kwamokArgs, fsetArgs>
	<#if fsetArgs?length < 4>
		<#return fsetArgs>
	<#else>
		<#if fsetArgs = "Z999">
			<#return "<font style='font-size:11px;'>교재종료</font>">
		<#elseif fsetArgs = "5000">
			<#if kwamokArgs = "G">
				<#return "국어0">
			<#else>
				<#return "영어0">
			</#if>
		<#elseif fsetArgs = "5001"> 
			<#if kwamokArgs = "G">
				<#return "국어1">
			<#else>
				<#return "영어1">
			</#if>
		<#elseif fsetArgs?substring(1,4) = "000"> 
			<#return fsetArgs?substring(0,1)+"진단">
		<#elseif fsetArgs?substring(1,4) = "999">
			<#return fsetArgs?substring(0,1)+"총괄">
		<#elseif fsetArgs?substring(1,4) = "992">
			<#return fsetArgs?substring(0,1)+"총필">
		<#elseif fsetArgs?substring(1,4) = "994">
			<#return fsetArgs?substring(0,1)+"진필">
		<#else>
			<#return fsetArgs>
		</#if>
	</#if>
</#function>
<#function UFNDisplayJinSetE kwamokArgs, fsetArgs>
	<#if fsetArgs?length < 4>
		<#return fsetArgs>
	<#else>
		<#if fsetArgs = "Z999">
			<#return "<font style='font-size:11px;'>COM</font>">
		<#elseif fsetArgs = "5000">
			<#if kwamokArgs = "G">
				<#return "국어0">
			<#else>
				<#return "영어0">
			</#if>
		<#elseif fsetArgs = "5001"> 
			<#if kwamokArgs = "G">
				<#return "국어1">
			<#else>
				<#return "영어1">
			</#if>
		<#elseif fsetArgs?substring(1,4) = "000"> 
			<#return fsetArgs?substring(0,1)+"-Dig.">
		<#elseif fsetArgs?substring(1,4) = "999">
			<#return fsetArgs?substring(0,1)+"-Ach.">
		<#elseif fsetArgs?substring(1,4) = "992">
			<#return fsetArgs?substring(0,1)+"-Rev.">
		<#elseif fsetArgs?substring(1,4) = "994">
			<#return fsetArgs?substring(0,1)+"-Prep.">
		<#else>
			<#return fsetArgs>
		</#if>
	</#if>
</#function>


<#function UFNDisplayOdab odabArgs>
	<#if odabArgs = "01">
		<#return "①">
	<#elseif odabArgs = "02">
		<#return "②">
	<#elseif odabArgs = "03">
		<#return "③">
	<#elseif odabArgs = "04">
		<#return "④">
	<#elseif odabArgs = "05">
		<#return "⑤">
	<#elseif odabArgs = "06">
		<#return "⑥">
	<#elseif odabArgs = "07">
		<#return "⑦">
	<#elseif odabArgs = "08">
		<#return "⑧">
	<#elseif odabArgs = "09">
		<#return "⑨">
	<#elseif odabArgs = "10">
		<#return "⑩">
	<#elseif odabArgs = "11">
		<#return "⑪">
	<#elseif odabArgs = "12">
		<#return "⑫">
	<#else>
		<#return odabArgs>
	</#if>
</#function>

<#function UFNDisplayMonth MonthArgs>
	<#if MonthArgs = 1>
		<#return "JAN">
	<#elseif MonthArgs = 2>
		<#return "FEB">
	<#elseif MonthArgs = 3>
		<#return "MAR">
	<#elseif MonthArgs = 4>
		<#return "APR">
	<#elseif MonthArgs = 5>
		<#return "MAY">
	<#elseif MonthArgs = 6>
		<#return "JUN">
	<#elseif MonthArgs = 7>
		<#return "JUL">
	<#elseif MonthArgs = 8>
		<#return "AUG">
	<#elseif MonthArgs = 9>
		<#return "SEP">
	<#elseif MonthArgs = 10>
		<#return "OCT">
	<#elseif MonthArgs = 11>
		<#return "NOV">
	<#elseif MonthArgs = 12>
		<#return "DEC">
	</#if>
</#function>
