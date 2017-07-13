/**
 * This spec is to test the reload function
 */

describe('ReLoad 60 Seconds', function () {
	  it('LoadTest', function () {
		 
		  expect(reLoad()).toEqual('test');
	    
	  });
	});
/*This spec is to test Search*/
describe('Search', function () {
	  it('mySearch', function () {
		  mySearch();
		  var a =document.getElementById("myInput");
		  expect(a.is(":hidden")).toBe(true);
		 
	    
	  });
	});
