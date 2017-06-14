<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>米粉之家后台管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	
	var url;
/* 商品大类搜索 */
	function searchProductBigType(){
		$("#dg").datagrid('load',{
			"name":$("#s_productBigTypeName").val()
		});
	}
	/* 商品大类的增加 */
	function openProductBigTypeAddDialog(){
		$("#dlg").dialog("open").dialog("setTitle","添加商品大类信息");
		url="${pageContext.request.contextPath}/bigtypeapi/add";
	}
	
	/* 商品大类的保存 */
	function saveProductBigType(){
		$("#fm").form("submit",{
			url:url,
			onSubmit:function(){
				return $(this).form("validate");
			},
			success:function(result){
				var result=eval('('+result+')');
				if(result){
					$.messager.alert("系统提示","保存成功");
					resetValue();
					$("#dlg").dialog("close");
					$("#dg").datagrid("reload");
				}else{
					$.messager.alert("系统提示","保存失败");
					return;
				}
			}
		});
	}
	/* 商品大类的修改 */
	function openProductBigTypeModifyDialog(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","编辑商品大类信息");
		$("#name").val(row.name);
		$("#remarks").val(row.remarks);
		url="${pageContext.request.contextPath}/bigtypeapi/update/"+row.id;
	}
	/* 重置数据 */
	function resetValue(){
		$("#name").val("");
		$("#remarks").val("");
	}
	
	function closeProductBigTypeDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	/* 删除数据 */
	function deleteProductBigType(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要删除的数据！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].id);
		}
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确认要删除这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
			if(r){
				$.post("${pageContext.request.contextPath}/bigtypeapi/delete",{id:ids},function(result){
					if(result){
						if(result.success){
							$.messager.alert("系统提示",result.exist);
						}else{
							$.messager.alert("系统提示","数据已成功删除！");							
						}
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert("系统提示","数据删除失败！");
					}
				},"json");
			}
		});
		
	}
	
</script>
</head>
<body style="margin:1px;">
	<table id="dg" title="商品大类管理" class="easyui-datagrid"
	 fitColumns="true" pagination="true" rownumbers="true"
	 url="${pageContext.request.contextPath}/bigtypeapi/show" fit="true" toolbar="#tb">
	 <thead>
	 	<tr>
	 		<th field="cb" checkbox="true" align="center"></th>
	 		<th field="id" width="50" align="center">编号</th>
	 		<th field="name" width="100" align="center">商品大类名称</th>
	 		<th field="remarks" width="200" align="center">备注</th>
	 	</tr>
	 </thead>
	</table>
	
	<div id="tb">
		<div>
			<a href="javascript:openProductBigTypeAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			<a href="javascript:openProductBigTypeModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:deleteProductBigType()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
		</div>
		<div>
			&nbsp;商品大类名称：&nbsp;<input type="text" id="s_productBigTypeName" size="20" onkeydown="if(event.keyCode==13) searchProductBigType()"/>
			<a href="javascript:searchProductBigType()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
		</div>
	</div>
	
	<div id="dlg" class="easyui-dialog" style="width: 600px;height:300px;padding: 10px 20px"
	  closed="true" buttons="#dlg-buttons">
	 	<form id="fm" method="post">
	 		<table cellspacing="8px">
	 			<tr>
	 				<td>大类名称：</td>
	 				<td colspan="3"><input type="text" id="name" name="name" class="easyui-validatebox" required="true"/></td>
	 			</tr>
	 			<tr>
	 				<td valign="top">备注：</td>
	 				<td colspan="3">
	 					<textarea rows="7" cols="50" id="remarks" name="remarks"></textarea>
	 				</td>
	 			</tr>
	 		</table>
	 	</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:saveProductBigType()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeProductBigTypeDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>