 public boolean isPermissionAllowed(Context context,String singlePermission) 
  {
        boolean flag;
        int result = ContextCompat.checkSelfPermission(context, singlePermission);
        //If permission is granted returning true
        if (result == PackageManager.PERMISSION_GRANTED)
        {
            flag = true;
        }
        else
        {
            //If permission is not granted returning false
            flag = false;
        }
        return flag;
    }

private void ButtonClickEvent()
{
  
     if(     new MyConfiguration().isPermissionAllowed(getContext(),Manifest.permission.READ_PHONE_STATE) &&
           new MyConfiguration().isPermissionAllowed(getContext(),Manifest.permission.ACCESS_FINE_LOCATION) &&
           new MyConfiguration().isPermissionAllowed(getContext(),Manifest.permission.RECEIVE_SMS) &&
           new MyConfiguration().isPermissionAllowed(getContext(),Manifest.permission.READ_SMS)
     )
   {
     //got the all permission
     //do your work
   }
  else
  {
        //not have permission , request for permission
        //below code with get the result into fragment
        //note: if you want to get the result into Activity , then add <activity> object into 1st parameter of requestPermissions method i.e requestPermissions(activity,permissions,permission code)
        requestPermissions(new String[]{
                              Manifest.permission.READ_PHONE_STATE,
                              Manifest.permission.ACCESS_FINE_LOCATION,
                              Manifest.permission.RECEIVE_SMS,
                              Manifest.permission.READ_SMS},PERMISSION_CODE);
  }
  
}
