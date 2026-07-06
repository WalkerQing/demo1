可以把这个 Skill 再完善一下，增加验证结果和改动符合性评估。这样 Claude 在完成修改后，不会只说”修改完成”，而是必须给出证据说明是否真的符合需求。

---
name: update-api-call
description: Modify backend API calls, ensure the application is running, verify the change, and report whether the implementation matches the requested behavior.
tools:
  - idea
  - terminal
  - chrome-devtools
---
# Purpose
You are responsible ONLY for modifying API calls and validating the result.
Your task is not complete until the implementation has been verified against a running application.
---
# Workflow
## 1. Understand the request
- Read the requested change.
- Locate the complete request chain.
- Understand the impact before editing.
Possible locations:
- Controller
- Service
- Feign
- RestTemplate
- WebClient
- Axios
- fetch
- Retrofit
- API Client
Do not modify unrelated code.
---
## 2. Modify the implementation
Update only the requested behavior.
Avoid:
- Refactoring
- Formatting-only changes
- Renaming unrelated variables
- Unnecessary optimizations
---
## 3. Ensure the application is running
### If the application is NOT running
Start the application using the project's standard startup configuration.
Wait until startup completes successfully.
---
### If the application IS already running
Do NOT restart it.
Obtain the runtime port using the following priority:
1. Current running Application in IDEA
2. Spring Boot startup log
3. JVM startup arguments
4. Environment variables
5. application-*.yml
6. application.yml
Never assume port 8080.
---
## 4. Verify with Chrome DevTools
Open
http://localhost:{runtime_port}
Perform the modified workflow.
Validate:
- Network Request
- Response Status
- Response Body
- Request Payload
- Request Headers
- Browser Console
Capture any unexpected errors.
---
## 5. Evaluate the result
Compare:
Expected behavior
vs
Actual behavior
Determine one of:
✅ Fully matches requirements
⚠️ Partially matches requirements
❌ Does not match requirements
Explain why.
If verification cannot be completed, clearly explain the blocker instead of guessing.
---
## 6. Final Report
Output the following sections.
### Summary
Brief description of the completed work.
---
### Files Modified
- file1
- file2
---
### API Changes
Describe exactly what changed.
---
### Runtime Information
Application Status:
Running / Started
Runtime Port:
xxxx
---
### Verification Results
| Check | Result | Notes |
|--------|--------|-------|
| Application Running | ✅ / ❌ | |
| API Reachable | ✅ / ❌ | |
| Network Request | ✅ / ❌ | |
| Status Code | ✅ / ❌ | |
| Response Body | ✅ / ❌ | |
| Browser Console | ✅ / ❌ | |
---
### Requirement Compliance
Requirement:
<original request>
Implementation:
<what was actually implemented>
Assessment:
✅ Fully Matches
⚠️ Partially Matches
❌ Does Not Match
Reason:
Explain why.
---
### Risks
List any remaining risks or assumptions.
---
### Next Recommendations
Optional improvements if applicable.
---
# Principles
- Never assume the runtime port.
- Never assume the application started successfully.
- Never claim success without verification.
- Always compare expected behavior with actual behavior.
- If verification fails, explain why instead of guessing.
- Every completed task must end with the Final Report.

我还建议再增加一个要求：如果项目包含自动化测试，优先运行与改动相关的测试（单元测试、集成测试等），再进行浏览器验证。最终报告可以增加一项：

Validation	Result
Related Tests	✅ 12 Passed / ❌ 1 Failed
Browser Verification	✅
Requirement Compliance	✅ Fully Matches

这样这个 Skill 就形成了完整闭环：改代码 → 启动应用 → 获取真实端口 → 运行测试 → 浏览器验证 → 输出符合性结论，基本符合团队开发中的交付标准。
