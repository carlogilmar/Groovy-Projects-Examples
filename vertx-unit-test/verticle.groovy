import io.vertx.groovy.ext.unit.TestSuite

def suite = TestSuite.create("the_test_suite")

suite.beforeEach({ context ->
  def a="before"
  context.assertEquals("before", a)
})

suite.test("my_test_case_1", { context ->
  def s = "value"
  context.assertEquals("value", s)
}).test("my_test_case_3",{context ->
  def a=123
  context.assertEquals(123,a)
})

suite.test("my_test_case_4", { context ->
    context.assertEquals(10, callbackCount)
})

suite.test("my_test_case_2", { context ->
  def s = "value"
  context.assertEquals("value", s)
})

suite.afterEach({ context ->
  def a="after"
  context.assertEquals("after",a)
})

suite.run([
reporters:[
[
to:"console"
]
]
])
