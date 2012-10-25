<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:if test="${contextPath == '/'}">
	<c:set var="contextPath" value=""/>
</c:if>
<input type="hidden" id="contextPath" value="${contextPath}"><!-- for JS scrips -->
		
		
		
		
	<c:forEach items="${dispositivos}" var="d">
		
		
		<c:out value="${d.nome}"></c:out>
		
	
	</c:forEach>
		
	<display:table name="dispositivos" />
		
		
	<section class="grid_12">
			<div class="block-border">
			
			<form class="block-content form" id="table_form" method="post" action="">
				<h1>Table</h1>
				
				<div class="block-controls">
					
					<ul class="controls-buttons">
						<li><a href="#" title="Previous"><img src="images/icons/fugue/navigation-180.png" width="16" height="16"> Prev</a></li>
						<li><a href="#" title="Page 1"><b>1</b></a></li>
						<li><a href="#" title="Page 2" class="current"><b>2</b></a></li>
						<li><a href="#" title="Page 3"><b>3</b></a></li>
						<li><a href="#" title="Page 4"><b>4</b></a></li>
						<li><a href="#" title="Page 5"><b>5</b></a></li>
						<li><a href="#" title="Next">Next <img src="images/icons/fugue/navigation.png" width="16" height="16"></a></li>
						<li class="sep"></li>
						<li><a href="#"><img src="images/icons/fugue/arrow-circle.png" width="16" height="16"></a></li>
					</ul>
					
				</div>
			
				<div class="no-margin"><table class="table" cellspacing="0" width="100%">
				
					<thead>
						<tr>
							<th class="black-cell"><span class="loading"></span></th>
							<th scope="col">
								<span class="column-sort">
									<a href="#" title="Sort up" class="sort-up active"></a>
									<a href="#" title="Sort down" class="sort-down"></a>
								</span>
								Title
							</th>
							<th scope="col">Keywords</th>
							<th scope="col">Preview</th>
							<th scope="col">
								<span class="column-sort">
									<a href="#" title="Sort up" class="sort-up"></a>
									<a href="#" title="Sort down" class="sort-down"></a>
								</span>
								Date
							</th>
							<th scope="col">
								<span class="column-sort">
									<a href="#" title="Sort up" class="sort-up"></a>
									<a href="#" title="Sort down" class="sort-down"></a>
								</span>
								Size
							</th>
							<th scope="col" class="table-actions">Actions</th>
						</tr>
					</thead>
					
					<tbody>
						
						<tr>
							<th scope="row" class="table-check-cell"><input type="checkbox" name="selected[]" id="table-selected-1" value="1"></th>
							<td>Lorem ipsum sit amet</td>
							<td><ul class="keywords">
								<li><a href="#">Ocean</a></li>
								<li class="orange-keyword"><a href="#">Sun</a></li>
							</ul></td>
							<td><a href="#"><small><img src="images/icons/fugue/image.png" width="16" height="16" class="picto"> jpg | 12 Ko</small></a></td>
							<td>02-05-2010</td>
							<td>320 x 240</td>
							<td class="table-actions">
								<a href="#" title="Edit" class="with-tip"><img src="images/icons/fugue/pencil.png" width="16" height="16"></a>
								<a href="#" title="Delete" class="with-tip"><img src="images/icons/fugue/cross-circle.png" width="16" height="16"></a>
							</td>
						</tr>
						
						<tr>
							<th scope="row" class="table-check-cell"><input type="checkbox" name="selected[]" id="table-selected-2" value="2"></th>
							<td>Lorem ipsum sit amet</td>
							<td><ul class="keywords">
								<li class="purple-keyword">People</li>
							</ul></td>
							<td><a href="#"><small><img src="images/icons/fugue/image.png" width="16" height="16" class="picto"> jpg | 12 Ko</small></a></td>
							<td>02-05-2010</td>
							<td>320 x 240</td>
							<td class="table-actions">
								<a href="#" title="Edit" class="with-tip"><img src="images/icons/fugue/pencil.png" width="16" height="16"></a>
								<a href="#" title="Delete" class="with-tip"><img src="images/icons/fugue/cross-circle.png" width="16" height="16"></a>
							</td>
						</tr>
						
						<tr>
							<th scope="row" class="table-check-cell"><input type="checkbox" name="selected[]" id="table-selected-3" value="3"></th>
							<td>Lorem ipsum sit amet</td>
							<td><ul class="keywords">
								<li>Sea</li>
								<li>Fish</li>
								<li>Bubble</li>
							</ul></td>
							<td><a href="#"><small><img src="images/icons/fugue/image.png" width="16" height="16" class="picto"> jpg | 12 Ko</small></a></td>
							<td>02-05-2010</td>
							<td>320 x 240</td>
							<td class="table-actions">
								<a href="#" title="Edit" class="with-tip"><img src="images/icons/fugue/pencil.png" width="16" height="16"></a>
								<a href="#" title="Delete" class="with-tip"><img src="images/icons/fugue/cross-circle.png" width="16" height="16"></a>
							</td>
						</tr>
						
						<tr>
							<th scope="row" class="table-check-cell"><input type="checkbox" name="selected[]" id="table-selected-4" value="4"></th>
							<td>Lorem ipsum sit amet</td>
							<td class="empty">(none)</td>
							<td><a href="#"><small><img src="images/icons/fugue/image.png" width="16" height="16" class="picto"> jpg | 12 Ko</small></a></td>
							<td>02-05-2010</td>
							<td>320 x 240</td>
							<td class="table-actions">
								<a href="#" title="Edit" class="with-tip"><img src="images/icons/fugue/pencil.png" width="16" height="16"></a>
								<a href="#" title="Delete" class="with-tip"><img src="images/icons/fugue/cross-circle.png" width="16" height="16"></a>
							</td>
						</tr>
						
						<tr>
							<th scope="row" class="table-check-cell"><input type="checkbox" name="selected[]" id="table-selected-5" value="5"></th>
							<td>Lorem ipsum sit amet</td>
							<td><ul class="keywords">
								<li>Ocean</li>
							</ul></td>
							<td><a href="#"><small><img src="images/icons/fugue/image.png" width="16" height="16" class="picto"> jpg | 12 Ko</small></a></td>
							<td>02-05-2010</td>
							<td>320 x 240</td>
							<td class="table-actions">
								<a href="#" title="Edit" class="with-tip"><img src="images/icons/fugue/pencil.png" width="16" height="16"></a>
								<a href="#" title="Delete" class="with-tip"><img src="images/icons/fugue/cross-circle.png" width="16" height="16"></a>
							</td>
						</tr>
					</tbody>
				
				</table></div>
				
				<ul class="message no-margin">
					<li>Results 1 - 5 out of 23</li>
				</ul>
				
				<div class="block-footer">
					<div class="float-right">
						<label for="table-display" style="display:inline">Display mode</label>
						<select name="table-display" id="table-display" class="small">
							<option value="table">Table</option>
							<option value="grid">Grid</option>
						</select>
					</div>
					
					<img src="images/icons/fugue/arrow-curve-000-left.png" width="16" height="16" class="picto"> 
					<a href="#" class="button">Select All</a> 
					<a href="#" class="button">Unselect All</a>
					<span class="sep"></span>
					<select name="table-action" id="table-action" class="small">
						<option value="">Action for selected...</option>
						<option value="validate">Validate</option>
						<option value="delete">Delete</option>
					</select>
					<button type="submit" class="small">Ok</button>
				</div>
					
			</form></div>
		</section>
		
		
			

		
	


