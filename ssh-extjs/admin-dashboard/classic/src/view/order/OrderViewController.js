Ext.define('Admin.view.order.OrderViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.orderViewController',

    orderGridOpenAddWindow: function(bt) {
      var cfg = Ext.apply({
      	xtype:'OrderGridWindow',
      	items: [Ext.apply({xtype: 'orderGridForm'})]
      },{
    	  title:'创建订单'
      });
      Ext.create(cfg);
  },
     orderGridOpenEditWindow: function(bt) {
       alert("On Click");
    },
     orderGridOpenDeleteDate: function(bt) {
       alert("On Click");
    },

    orderGridFormSubmit: function(btn) {
		var orderGridForm = btn.up('form').getForm();
		var win = btn.up('window');
		orderGridForm.submit( {
			//waitTitle : '请稍后...',
			//waitMsg : '正在保存订单信息,请稍后...',
			url : 'order/saveOrUpdate',
			method : 'post',
			success : function(form, action) {
				Ext.Msg.alert("提示",action.result.msg);
				win.close();
				Ext.getCmp('orderGrid').store.reload();
			},
			failure : function(form, action) {
				Ext.Msg.alert("提示",action.result.msg);

			}
		});
    },

	orderGridWindowClose: function(btn) {
		var win = btn.up('window');
		if(win){
			win.close();
		}
    }
});