import pygame
import random

pygame.init()
width, height = 600, 400
win = pygame.display.set_mode((width, height))
clock = pygame.time.Clock()

snake = [(100, 100)]
dx, dy = 10, 0
food = (random.randint(0, width//10)*10, random.randint(0, height//10)*10)

running = True
while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
    keys = pygame.key.get_pressed()
    if keys[pygame.K_LEFT]: dx, dy = -10, 0
    elif keys[pygame.K_RIGHT]: dx, dy = 10, 0
    elif keys[pygame.K_UP]: dx, dy = 0, -10
    elif keys[pygame.K_DOWN]: dx, dy = 0, 10

    new_head = (snake[-1][0] + dx, snake[-1][1] + dy)
    snake.append(new_head)
    if new_head == food:
        food = (random.randint(0, width//10)*10, random.randint(0, height//10)*10)
    else:
        snake.pop(0)

    win.fill((0, 0, 0))
    pygame.draw.rect(win, (255, 0, 0), (*food, 10, 10))
    for seg in snake:
        pygame.draw.rect(win, (0, 255, 0), (*seg, 10, 10))
    pygame.display.update()
    clock.tick(10)
pygame.quit()
