<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">

	<div class="row">

		<c:if test="${not empty message}">

			<div class="col-xs-12">
				<div class="alert alert-succcess alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>

					${message}
				</div>
			</div>
		</c:if>
		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">

				<div class="panel-heading">

					<h4>Product Management</h4>

				</div>

				<div class="panel-body">
					<!-- FORM ELEMENTS -->

					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data">
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								Product Name: </label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
								<sf:errors path="name" class="help-block" element="em"></sf:errors>

							</div>

						</div>


						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter
								Brand Name: </label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand"
									placeholder="Brand Name" class="form-control" />
								<sf:errors path="brand" class="help-block" element="em"></sf:errors>
							</div>

						</div>


						<div class="form-group">
							<label class="control-label col-md-4" for="description">Product
								Description: </label>
							<div class="col-md-8">
								<sf:textarea path="description" id="description" rows="4"
									placeholder="Write a Description here!" class="form-control"></sf:textarea>
								<sf:errors path="description" class="help-block" element="em"></sf:errors>
							</div>

						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Enter
								Unit Price: </label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" id="unitPrice"
									placeholder="Unit Price In &#8377" class="form-control" />

								<sf:errors path="unitPrice" class="help-block" element="em"></sf:errors>

							</div>

						</div>


						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Quantity
								Available: </label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity"
									placeholder="Quantity Available" class="form-control" />

							</div>

						</div>

						<!-- File element for image upload -->
						<div class="form-group">
							<label class="control-label col-md-4" for="file">Select
								an Image: </label>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file" class="form-control" />
								<sf:errors path="file" cssClass="help-block" element="em"></sf:errors>
							</div>

						</div>


						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Select
								Category: </label>
							<div class="col-md-8">

								<sf:select class="form-control" id="categoryId"
									path="categoryId" size="1" items="${categories}"
									itemLabel="name" itemValue="id">
								</sf:select>
								
								<c:if test="${product.id ==0}" >
								
								<div class="text-right">
								<br/>
								<button type="button" data-toggle="modal" data-target="#myCategoryModal" class="btn btn-warning btn-sm">Add Category</button>
								</div>
								</c:if>


							</div>

						</div>


						<div class="form-group">

							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="Submit"
									class="btn btn-primary" />

								<!-- Hidden Fields -->
								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="active" />
								<sf:hidden path="purchases" />
								<sf:hidden path="views" />

							</div>

						</div>



					</sf:form>


				</div>

			</div>

		</div>



	</div>

	<div class="row">
		<div class="col-xs-12">  
			<h3>Available Product</h3>
			<hr/>
		 </div>

		<div class="col-xs-12">

			<div style="overflow: auto">

				<!-- Product table for admin -->

				<table id="adminProductTable"
					class="table table-striped table-bordered">

					<thead>
						<tr>
							<th>ID</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</thead>
					
					<tfoot>
						<tr>
							<th>ID</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</tfoot>
				</table>

			</div>
		</div>


	</div>


	<div class="modal fade" id="myCategoryModal" role="dialog" tabindex="-1">
	
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			
			<!-- Modal Header -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
					<h4 class="modal-title">Add new Category</h4>
				</div>
				
			<!-- Modal Body -->	
				<div class="modal-body">
					<!-- Category Form -->
					
				
				</div>
			</div>
		</div>
	
	</div>
</div>