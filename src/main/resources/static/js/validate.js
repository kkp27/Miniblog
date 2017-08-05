<script type="text/javascript">

var pwdvalue1 = document.getElementById('password').value;
var pwdvalue2 = document.getElementById('confirmPassword').value);

function checkMatch() {
		if (pwdvalue1 != pwdvalue2) {
			document.getElementById('msg').innerHTMl = "passwords do not match";
			document.getElementById('msg').style.color = 'red';
			return false;
		}
	}
	
</script>