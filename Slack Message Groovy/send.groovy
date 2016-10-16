import in.ashwanthkumar.slack.webhook.Slack
import in.ashwanthkumar.slack.webhook.SlackMessage

@Grapes(
  @Grab(group='in.ashwanthkumar', module='slack-java-webhook', version='0.0.7')
	)

def webhookUrl = "http:/webhokks.tag.something"

new Slack(webhookUrl)
	.icon(":bangbang:") // Ref - http://www.emoji-cheat-sheet.com/
	.sendToChannel("General")
	.displayName("Bot de Prueba")
	.push(new SlackMessage("Salu2 ").bold("Soy el Bot"));
