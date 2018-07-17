export class App {
  configureRouter(config, router) {
    config.title = 'Emp Demo';
    config.map([
		{ route: ['', 'empList'], name: 'empList',      moduleId: 'admin/employee/list/employee-list',   nav: true, title: 'list' },
		{ route: 'empCreateOrUpdate/:id?',href:'empCreateOrUpdate', name: 'empCreateOrUpdate',      moduleId: 'admin/employee/create/employee-create-or-update',   title: 'Create or Update' },
		{ route: 'empView/:id?',href:'empView', name: 'empView',      moduleId: 'admin/employee/view/employee-view',  title: 'View' }
    ]);

    this.router = router;
  }
}
 